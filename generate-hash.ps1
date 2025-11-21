$version = "2.0.0"
$baseName = "infobank-omni-sdk-java"

$libPath = "build\libs"
$pomPath = "build\publications\mavenJava\pom-default.xml"

# JAR & Sources & Javadoc
$files = @(
    "$libPath\$baseName-$version.jar",
    "$libPath\$baseName-$version-sources.jar",
    "$libPath\$baseName-$version-javadoc.jar",
    $pomPath
)

foreach ($file in $files) {

    if (-Not (Test-Path $file)) {
        Write-Host "❌ Skip: $file (not found)"
        continue
    }

    Write-Host "✔ Generating hashes for $file"

    $md5 = (Get-FileHash $file -Algorithm MD5).Hash.ToLower()
    $sha1 = (Get-FileHash $file -Algorithm SHA1).Hash.ToLower()

    Set-Content "$file.md5" $md5
    Set-Content "$file.sha1" $sha1
}

Write-Host "🎉 Done! MD5 / SHA1 files created."
