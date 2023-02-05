@echo off
for %%f in (*) do (
  set "newname=%%~nf"
  set "newname=%newname: =-"%
  set "newname=%newname:---=-%"
  set "newname=%newname:--=-%"
  set "newname=%newname:+==-%"
  set "newname=%newname:_=-%"
  set "oldname=%%~nf"
  ren "%%f" "%newname%"
  echo "[System] Renamed the file (%newname%) by (%newname%)"
)
pause