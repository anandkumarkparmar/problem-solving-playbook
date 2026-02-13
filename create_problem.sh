#!/bin/bash

# Script to create a new problem folder with README and run script

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROBLEMS_DIR="$SCRIPT_DIR/problems"

# Function to display usage
usage() {
    echo "Usage: $0 <category> <problem_number> <problem_name> [--readme]"
    echo "Example: $0 array 1 TwoSum"
    echo "Example: $0 queue 605 CanPlaceFlowers --readme"
    echo ""
    echo "Arguments:"
    echo "  category         Subfolder under problems (e.g., array, queue, stack)"
    echo "  problem_number   LeetCode problem number (numeric)"
    echo "  problem_name     Kotlin-friendly name (e.g., TwoSum, CanPlaceFlowers)"
    echo ""
    echo "Options:"
    echo "  --readme, -r     Create README.md file (default: false)"
    exit 1
}

# Initialize variables
CREATE_README=false
CATEGORY=""
PROBLEM_NUMBER=""
PROBLEM_NAME=""

# Parse arguments
while [[ $# -gt 0 ]]; do
    case $1 in
        --readme|-r)
            CREATE_README=true
            shift
            ;;
        *)
            if [ -z "$CATEGORY" ]; then
                CATEGORY="$1"
            elif [ -z "$PROBLEM_NUMBER" ]; then
                PROBLEM_NUMBER="$1"
            elif [ -z "$PROBLEM_NAME" ]; then
                PROBLEM_NAME="$1"
            else
                echo "Error: Unexpected argument: $1"
                usage
            fi
            shift
            ;;
    esac
done

# Check if required arguments are provided
if [ -z "$CATEGORY" ] || [ -z "$PROBLEM_NUMBER" ] || [ -z "$PROBLEM_NAME" ]; then
    echo "Error: Missing required arguments"
    usage
fi

# Validate problem number (should be numeric)
if ! [[ "$PROBLEM_NUMBER" =~ ^[0-9]+$ ]]; then
    echo "Error: Problem number must be numeric"
    usage
fi

# Validate category directory exists (or create it)
CATEGORY_PATH="$PROBLEMS_DIR/$CATEGORY"
if [ ! -d "$CATEGORY_PATH" ]; then
    echo "Category '$CATEGORY' does not exist. Creating it..."
    mkdir -p "$CATEGORY_PATH"
fi

# Format problem number with leading zeros (4 digits)
FORMATTED_NUMBER=$(printf "%04d" "$PROBLEM_NUMBER")

# Convert problem name to PascalCase for Kotlin file name
# Ensure first letter is uppercase
KOTLIN_CLASS_NAME=$(echo "$PROBLEM_NAME" | awk '{print toupper(substr($0,1,1)) substr($0,2)}')

# Convert problem name to camelCase for function name
# Lowercase first letter
FUNCTION_NAME=$(echo "$PROBLEM_NAME" | awk '{print tolower(substr($0,1,1)) substr($0,2)}')

# Create folder name inside category
FOLDER_NAME="LC${FORMATTED_NUMBER}_${PROBLEM_NAME}"
FOLDER_PATH="$CATEGORY_PATH/$FOLDER_NAME"

# Check if folder already exists
if [ -d "$FOLDER_PATH" ]; then
    echo "Error: Folder $FOLDER_NAME already exists!"
    exit 1
fi

# Create the folder
mkdir -p "$FOLDER_PATH"
echo "✓ Created folder: $FOLDER_NAME"

# Create README.md if requested
if [ "$CREATE_README" = true ]; then
    README_PATH="$FOLDER_PATH/README.md"
    cat > "$README_PATH" << EOF
# LeetCode $PROBLEM_NUMBER: $PROBLEM_NAME

## Problem Description

[Add problem description here]

## Examples

\`\`\`
Example 1:
Input: 
Output: 
Explanation: 

Example 2:
Input: 
Output: 
Explanation: 
\`\`\`

## Constraints

- [Add constraints here]

## Approach

[Add your approach explanation here]

## Complexity Analysis

- **Time Complexity:** O(?)
- **Space Complexity:** O(?)

## Solution

See \`${KOTLIN_CLASS_NAME}.kt\` for the implementation.
EOF
    echo "✓ Created README.md"
fi

# Create Kotlin solution file
KOTLIN_FILE_PATH="$FOLDER_PATH/${KOTLIN_CLASS_NAME}.kt"
cat > "$KOTLIN_FILE_PATH" << EOF
class Solution {
    // Time: O(?)
    // Space: O(?)
    fun ${FUNCTION_NAME}(/* TODO: Add parameters */): /* TODO: Add return type */ {
        // TODO: Implement solution
        return TODO()
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        // TODO: Add test cases
    )

    for (testCase in testCases) {
        println("Input: \$testCase")
        println("-------------")
        val result = solution.${FUNCTION_NAME}(testCase)
        println("Output: \$result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
EOF
echo "✓ Created ${KOTLIN_CLASS_NAME}.kt"

# Create run script
RUN_SCRIPT_PATH="$FOLDER_PATH/run.sh"
cat > "$RUN_SCRIPT_PATH" << 'EOF'
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
EOF
chmod +x "$RUN_SCRIPT_PATH"
echo "✓ Created run.sh"

echo ""
echo "✓ Problem folder created successfully!"
echo "  Location: $FOLDER_PATH"
echo ""

# Move into the new problem folder.
# Note: this only affects your terminal if you *source* this script, e.g.:
#   source create_problem.sh array 1 TwoSum
cd "$FOLDER_PATH" || exit 1

echo "Now in folder: $(pwd)"
echo ""
echo "Next steps:"
if [ "$CREATE_README" = true ]; then
    echo "  1. Edit README.md with problem description"
    echo "  2. Implement solution in ${KOTLIN_CLASS_NAME}.kt"
else
    echo "  1. Implement solution in ${KOTLIN_CLASS_NAME}.kt"
fi
echo "  3. Run: ./run.sh"
