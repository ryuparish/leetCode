def distinct_subarrays(nums,K):
    ans = 0
    n = len(nums)
    for i in range(n):
        temp2 = []
		# k represents the position to check when seeing how many
		# odd numbers the subset would contain if 
        k = 0
        check = set()
        # This loop below checks the sliding window of size i.
		# k will slowly become a further and further "lag pointer"
		# because j will start at an incrementally further position
		# each time.
        for j in range(i,n):
			# Activates only on the first iteration of i
            if i == 0:
				temp2.append(nums[j]%2)
				# Checking if current subset is valid and not duped
                if temp2[k] <= K and nums[j] not in check:
                    ans+=1
                    check.add(nums[j])
			# Activates after the first iteration
            else:
                temp2.append(temp1[k]+nums[j]%2)
				# Checking if current subset is valid and not duped
                if temp2[k] <= K and tuple(nums[k:j+1]) not in check:
                    ans+=1
                    check.add(tuple(nums[k:j+1]))
            k+=1
		# temp1 is dp. It represents the current and updated number of
		# odd numbers in the subset from i to j for each position k.
        temp1 = list(temp2)
    
    return ans
