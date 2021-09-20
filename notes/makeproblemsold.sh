#!/bin/bash
# Creating file that contains all the problem relative paths 
touch files.txt
for dir in */; do
    if [ "$dir" != "humblers" ]; then
        for file in "$dir"*; do
            echo "$file" >> files.txt
        done
    fi
done

# Creating a cleaned version of the problems file
cat files.txt | cut -d / -f 2 > problems.txt
rm -f files.txt
