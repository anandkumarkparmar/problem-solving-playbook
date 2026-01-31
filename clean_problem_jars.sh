#!/bin/bash

# Script to clean all problem.jar files from problem directories

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROBLEMS_DIR="$SCRIPT_DIR/problems"

echo "Cleaning all problem.jar files..."

# Find and remove all problem.jar files
find "$PROBLEMS_DIR" -name "problem.jar" -type f -delete

# Count how many were removed
removed_count=$(find "$PROBLEMS_DIR" -name "problem.jar" -type f 2>/dev/null | wc -l | tr -d ' ')

if [ "$removed_count" -eq 0 ]; then
    echo "✓ All problem.jar files have been removed successfully!"
else
    echo "⚠ Warning: Some problem.jar files may still exist"
fi
