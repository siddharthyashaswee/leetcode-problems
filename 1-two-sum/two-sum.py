class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        # i = 0 #brute force
        # j = 1
        
        # for i in range(len(nums)):
        #     for j in range(len(nums)):

        #         if i == j:
        #             continue
                
        #         if nums[i]+nums[j] == target:
        #             return [i,j]


        hashmap = {}
        for i in range(len(nums)):
            if target-nums[i] in hashmap :
                return i, hashmap[target - nums[i]]
            else:
                hashmap[nums[i]] = i


            





        