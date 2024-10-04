x = 1
for num in range(45492171):
    x = (x * 55443322) % 68254939 # x will never grow beyond 12320

print(x)
