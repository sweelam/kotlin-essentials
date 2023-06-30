package com.learning

class Anagrams {
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        val pmap = mutableMapOf<Char, Int>()

        for (ch in p.toCharArray())
            pmap.put(
                ch,
                if (pmap[ch] == null) 1 else pmap[ch]!!.toInt() + 1
            )

        val smap = mutableMapOf<Char, Int>()
        var len = 0;
        val asArray = s.toCharArray()

        for ((idx, ch) in asArray.withIndex()) {
            smap.put(
                ch,
                if (smap.get(ch) == null) 1 else smap[ch]!!.toInt() + 1
            )

            len++

            var equal = true
            for (key in pmap.keys)
                if (!smap.contains(key) || smap[key]!!.toInt() != pmap[key]!!.toInt()) equal = false


            if ((idx + 1) >= p.length) {
                if (equal) result.add((idx + 1) - p.length)
                var firstChIn = asArray[(idx + 1) - p.length]
                smap.put(firstChIn, smap[firstChIn]!!.toInt() - 1)
            }
        }

        return result
    }

}

fun main() {
    val anagram = Anagrams()
    println("${anagram.findAnagrams("cbaebabacd", "abc")}")
    println("${anagram.findAnagrams("abab", "ab")}")
    println("${anagram.findAnagrams("baa", "aa")}")

}