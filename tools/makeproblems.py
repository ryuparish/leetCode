# Walking through all of the files recursively through a directory and
# subdirectories
from pathlib import Path
import os
def main():
    allFiles = []

    # os.walk returns the current walking directory, the subdirectories within it, and then finally the files within it.
    # It will iterate through every subdirectory, no matter how many are embedded. It prints the closest directory and all the
    # items listed then it iterates to the first subdirectory in the directory and does the same recursively.
    path = Path(os.getcwd())
    exclude = set(['.git', 'notes', 'tools'])

    # name is current directory's name
    for name, subdirs, files in os.walk(path):
        subdirs[:] = [d for d in subdirs if d not in exclude]

        # Calculating the number of folder names to add the the problem names
        depth = len(Path(name).parts) - len(path.parts)

        # Comma for unpacking
        prefix, = name.split("/", len(path.parts))[-1:]
        prefix = prefix + "/"

        # "files" contains either a file in current directory or subdirectory that has been recursed
        # until a file is found
        for filename in files:
            extension = filename.split(".")[-1]
            if extension in ['py', 'java', 'cpp', 'sql']:
                allFiles.append(prefix + filename)
            
    with open("problems.txt", 'w') as f:
        for filename in allFiles:
            f.write(filename + "\n")
main()
