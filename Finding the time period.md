# Task

A museum recorded the entering and leaving time for each visitor during the day with one minute precision. This resulted in N pairs, where the first value indicates the start and the second the end time of the visit. Find the time period when there were the most number of visitors in the museum and how many were there. The start and end of the visit time are both inclusive. For example, if one visitor arrived at 11:10 and the other left at 11:10, it is considered that at 11:10 there were 2 visitors in the museum.

# Solution

The solution is based on creating model where each minute of the day keeps the corresponding number of visitors.
1. The mapping "minute -> number of visitors" is created. 
2. Each time period given in the input means updating the mapping (increasing number of visitors for each minute in the time period).
3. Finding the minutes with maximum number of visitors and creating a timespan based on them.

# Application building

Simply run the Main class with argument - path to input text file e.g.

"src/main/resources/visiting-times.txt"

