$workspacePath = ".\workspace"

if (-not (Test-Path $workspacePath)) {
    Write-Host "[ERROR] Directory '$workspacePath' does not exist!" -ForegroundColor Red
    exit
}

Push-Location $workspacePath

try {
    Write-Host "Compiling Main.java..." -ForegroundColor Cyan
    javac Main.java

    if ($LASTEXITCODE -ne 0) {
        Write-Host "[ERROR] Compilation failed!" -ForegroundColor Red
        exit
    }

    Write-Host "Running test..." -ForegroundColor Cyan

    cmd.exe /c "java Main < input.txt > output.txt"

    Write-Host "---------------------------------------"
    Write-Host "YOUR OUTPUT:"
    Get-Content output.txt
    Write-Host "---------------------------------------"
    Write-Host "EXPECTED OUTPUT:"
    Get-Content expected.txt
    Write-Host "---------------------------------------"

    $outLines = (Get-Content output.txt) | ForEach-Object { $_.Trim() } | Where-Object { $_ -ne "" }
    $expLines = (Get-Content expected.txt) | ForEach-Object { $_.Trim() } | Where-Object { $_ -ne "" }

    $outClean = $outLines -join "`n"
    $expClean = $expLines -join "`n"

    if ($outClean -eq $expClean -and $outClean -ne "") {
        Write-Host "[RESULT] TEST PASSED!" -ForegroundColor Green
    } elseif ($outClean -eq "") {
        Write-Host "[RESULT] TEST FAILED! (Your program produced NO output)" -ForegroundColor Red
    } else {
        Write-Host "[RESULT] TEST FAILED! (Outputs differ)" -ForegroundColor Red
    }
}
finally {
    Remove-Item -ErrorAction SilentlyContinue output.txt, Main.class
    Pop-Location
}