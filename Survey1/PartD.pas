{
    Carter Copen
    This follows academic integrity policy
}

program PartD;
var n, k: integer;

function factorial(n: integer): real;
begin
  if n>1 then
    factorial:=n*factorial(n-1)
  else
    factorial:=1;
end;

function combination(n: integer; r: integer): real;
begin
  if (0 <= r) and (r <= n) then
    combination:=(factorial(n)/(factorial(r)*factorial(n-r)))
  else
    combination:=1;
end;

function hypercake(n: integer; k: integer): real;
var
    total: real;
    i: integer;
begin
    total:=0;
    for i:=0 to k do total:= total + combination(n,i);
        
    hypercake:=total
end;

begin
  write('Cuts:');
  readln(n);
  write('Dimensions:');
  readln(k);
  writeln(hypercake(n,k));
  
end.
