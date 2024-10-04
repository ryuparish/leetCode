import sys

def gcd(a, b):
    if (b > a):
        gcd(b, a)

    if b == 0:
        return a

    elif a == 0:
        return b

    return gcd(b, a % b)

if __name__ == "__main__":
    print(gcd(int(sys.argv[1]), int(sys.argv[2])))
