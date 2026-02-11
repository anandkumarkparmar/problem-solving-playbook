#!/bin/bash

# Script to compile and run the Kotlin solution

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
KOTLIN_FILE=$(find "$SCRIPT_DIR" -name "*.kt" -type f | head -n 1)

if [ -z "$KOTLIN_FILE" ]; then
    echo "Error: No Kotlin file found in $SCRIPT_DIR"
    exit 1
fi

echo "Compiling and running: $(basename "$KOTLIN_FILE")"
echo "----------------------------------"

# Compile Kotlin file
kotlinc "$KOTLIN_FILE" -include-runtime -d "$SCRIPT_DIR/Solution.jar" 2>&1

if [ $? -eq 0 ]; then
    # Run the compiled JAR
    java -jar "$SCRIPT_DIR/Solution.jar"
    
    # Clean up compiled JAR
    rm -f "$SCRIPT_DIR/Solution.jar"
else
    echo "Compilation failed!"
    exit 1
fi
