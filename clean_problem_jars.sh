#!/bin/bash

# Script to clean all problem.jar files from problem directories

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROBLEMS_DIR="$SCRIPT_DIR/problems"

echo "Cleaning all problem.jar files inside problems/* subfolders..."

# Find all problem.jar files (recursively, including category folders like array/, queue/, etc.)
JAR_FILES=$(find "$PROBLEMS_DIR" -type f -name "problem.jar" 2>/dev/null)

if [ -z "$JAR_FILES" ]; then
    echo "No problem.jar files found under $PROBLEMS_DIR"
    exit 0
fi

REMOVED_COUNT=$(printf "%s\n" "$JAR_FILES" | wc -l | tr -d ' ')

printf "Found %s problem.jar file(s). Deleting...\n" "$REMOVED_COUNT"
printf "%s\n" "$JAR_FILES" | xargs rm -f

echo "✓ Removed $REMOVED_COUNT problem.jar file(s) from nested problem folders."
