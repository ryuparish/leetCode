# For choosing a random problem out of my problems.txt file
import random
from sys import argv
def random_line(fname):
    lines = open(fname).read().splitlines()
    return random.choice(lines)
if(len(argv) < 2):
    print("Usage: python3 pickProblem.py <problem_file>")
    exit(1)
print(random_line(argv[1]))
