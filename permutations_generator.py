import itertools

def generate_permutations(n):
    # Generate an array of n integers: [0, 1, 2, ..., n-1]
    arr = list(range(n))
    # Use itertools to generate all permutations
    permutations = list(itertools.permutations(arr))
    return permutations

# Example usage
n = 3
perms = generate_permutations(n)
for perm in perms:
    print(perm)
