package Controller;

import Model.Exceptions.ToyException;
import Model.PrgState;
import Repository.IRepository;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Controller {
    private final IRepository repo;
    private ExecutorService executor;

    private boolean IS_FINISHED;
    private List<PrgState> prgList;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    public void setMain(PrgState state) {
        repo.setCurrentProgram(state);
    }

//    private Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heap){
//        return heap.entrySet().stream()
//                .filter(e->symTableValues.contains(e.getKey())).
//                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//    }
//
//    private void closeAllFiles(PrgState prg) {
//        prg.getFileTable().entrySey().forEach(
//                key -> {
//                    try {
//                        new CloseRFile(new ConstExpr(key.getKey())).execute(prg);
//                    } catch (ToyException e) {
//                        System.out.println(e.getMessage());
//                    }
//                });
//    }

    private void log(List<PrgState> prgList) {
        prgList.forEach(prg -> {
            try {
                repo.logPrgStateExec(prg);
                System.out.println(prg.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void oneStepForAllPrg(List<PrgState> prgList) throws InterruptedException {
        log(prgList);

        List<Callable<PrgState>> callList = prgList.stream()
                .map((PrgState p) -> (Callable<PrgState>)(p::oneStep))
                .collect(Collectors.toList());

        List<PrgState> newPrgList = executor.invokeAll(callList).stream().
                map(future -> {
                    try{
                        return future.get();
                    }
                    catch (InterruptedException|ExecutionException e){
                        System.out.println(e.getMessage());
                    }
                    return null;
                }).filter(Objects::nonNull).collect(Collectors.toList());

        prgList.addAll(newPrgList);

        log(prgList);

        repo.setPrgList(prgList);

    }

    public void allSteps() throws ToyException {
        executor = Executors.newFixedThreadPool(2);
        List<PrgState> prgList=removeCompletedPrg(repo.getPrgList());
        while (prgList.size() > 0){
            try
            {
                oneStepForAllPrg(prgList);
                prgList=removeCompletedPrg(repo.getPrgList());
            }
            catch (InterruptedException ie){
                throw new ToyException(ie.getMessage());
            }
        }
        executor.shutdownNow();
        repo.setPrgList(prgList);
    }

    public List<PrgState> removeCompletedPrg(ArrayList<PrgState> inPrgList) {
        return inPrgList.stream()
                .filter(PrgState::isNotCompleted)
                .collect(Collectors.toList());
    }

    public IRepository getRepo() {
        return repo;
    }

    public void setupExecutor() {
        IS_FINISHED = false;
        executor = Executors.newFixedThreadPool(2);
        prgList=removeCompletedPrg(repo.getPrgList());
    }

    public boolean oneStep() throws ToyException {
        if (prgList.size() > 0) {
            try
            {
                oneStepForAllPrg(prgList);
                prgList=removeCompletedPrg(repo.getPrgList());
                return true;
            }
            catch (InterruptedException ie){
                throw new ToyException(ie.getMessage());
            }
        }
        else if (!IS_FINISHED) {
            IS_FINISHED = true;
            executor.shutdownNow();
            repo.setPrgList(prgList);
            return false;
        }
        return false;
    }
}

