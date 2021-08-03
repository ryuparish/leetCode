// Basically, what this code does is loop "end" until all of the characters in t are found. Then, it starts to loop start from 0 until it finds the first character that is included in t. That's it, it
// just looks much more complicated than it is to cover the edge cases and functionality.
// 
// Stage 1 - Offset positively the character count in map by the characters in t.
// Stage 2 - Offset negatively the character count in map by the characters leading up to a substring that
//      contains all the letters in t within s (end is placed).
// Stage 3 - Offset map positvely for each letter in s until we find the first 0 count (place start).
string minWindow(string s, string t) {
	unordered_map<char, int> m;
    // Counting all the letters and their duplicates in m
	for (auto c : t) m[c]++;
	// counter represents the number of chars of t to be found in s.
	size_t start = 0, end = 0, counter = t.size(), minStart = 0, minLen = INT_MAX;
	size_t size = s.size();
	
	// Move end to find a valid window.
	while (end < size) {
		// If char in s exists in t, decrease counter
		if (m[s[end]] > 0)
			counter--;
		// Decrease m[s[end]]. If char does not exist in t, m[s[end]] will be negative.
		m[s[end]]--;
		end++;
        // When this loop below is activated, the map will have a negative values for every letter not in t, and for every letter in t,
        // either 0 or the number of excess duplicates in s (which will allow us to ignore [excess number] amount of the letter to find the "true" start)
        // 
        // For example (final position, as a single excess 's' was skipped:
        //      t = SIMS
        //      s = DESSSIMSABC
        //             ^  ^
        //             s  e
        //
        //
        // This loop will only go until a single letter withing t is found.
		while (counter == 0) {
			if (end - start < minLen) {
				minStart = start;
				minLen = end - start;
			}
			m[s[start]]++;
			// When char exists in t, increase counter.
			if (m[s[start]] > 0)
				counter++;
			start++;
		}
	}
	if (minLen != INT_MAX)
		return s.substr(minStart, minLen);
	return "";
}
