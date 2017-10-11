# Toy Language Description

A program (Prg) in this language consists of a statement (Stmt) as follows: Prg := Stmt where the symbol "::=" means "a Prg is defined as a Stmt".
A statement can be either a compound statement (CompStmt), or an assignment statement (AssignStmt), or a print statement (PrintStmt), or a conditional statement (IfStmt) as follows:
   Stmt ::= Stmt1 ; Stmt2 | Id = Exp
| Print(Exp)
| If Expr Then Stmt1 Else Stmt2
/* (CompStmt)*/ /* (AssignStmt)*/
/* (PrintStmt)*/ /* (IfStmt)*/
where the symbol "|" denotes the possible definition alternatives.

An expression (Exp) can be either an integer number (Const), or a variable name (Var), or an arithmetic expression (ArithExp) as follows:
Exp ::= Number | Id
| Exp1 + Exp2 | Exp1 - Exp2 | Exp1 * Exp2 | Exp1 / Exp2
/*(Const)*/ /*(Var)*/ /*(ArithExp)*/
where Number denotes an integer constant, and Id denotes a variable name.

Example1: v=2;
Print(v)

Example2:
a=2+3*5; b=a-4/2 + 7; Print(b)

Example3:
a=2-2;
If a Then v=2 Else v=3; Print(v)
