package practice.interview;

import java.util.*;
/*
# Suppose we have a series of people relationships that looks something like this:
#        [    ['Bart',  'brother',   'Lisa'    ],
#            ['Bart',  'son',      'Homer'    ],
#            ['Marge', 'wife',     'Homer'    ],
#            ['Lisa',  'daughter', 'Homer'   ]    ]
             ['Bart', "son", "Bob"]
#
#        i.e. inner lists have len == 3 and are in form name1, relationship, name2
#
# Given a series of relationships as a list of lists, and given two names, return
# all known "sequences" of relationships from name1 to name2
#
# e.g. with the lists above as input, with input names 'Bart' and 'Homer', you should return:
#    ['Bart son Homer', 'Bart brother Lisa daughter Homer']
#

given people names and relationship
bart - lisa  (brother)
     - homer (son)
lisa - homer (daughter)

build the graph - map<name, map<name, relationship>>
search the paths - dfs from start (given name)

recusive call - (map, start, end, path, restul set)
if (start == end) find the path, add to restult set
for (each neighbors) continue searching

*/

// #        [    ['Bart',  'brother',   'Lisa'    ],
// #            ['Bart',  'son',      'Homer'    ],
// #            ['Marge', 'wife',     'Homer'    ],
// #            ['Lisa',  'daughter', 'Homer'   ]    ]
// ['Bart son Homer', 'Bart brother Lisa daughter Homer']

// bart - lisa - bro
//      - homer - son
// marge - homer - wife
// lisa - homer - daughter

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        List<String> list1 = Arrays.asList("bart","brother","lisa");
        List<String> list5 = Arrays.asList("bart","friend","lisa");
        List<String> list2 = Arrays.asList("bart","son","homer");
        List<String> list3 = Arrays.asList("merge","wife","homer");
        List<String> list4 = Arrays.asList("lisa","daughter","homer");
        List<List<String>> input = new ArrayList<>();
        input.add(list1);
        input.add(list2);
        input.add(list3);
        input.add(list4);
        input.add(list5);
        String p1 = "bart", p2 = "homer";
        System.out.println(findAllSequences(input, p1, p2));
    }

    public static List<String> findAllSequences(List<List<String>> relation, String p1, String p2) {
        List<String> res = new ArrayList<>();
        if (p1.equals(p2)) return res;
        Map<String, Map<String, List<String>>> map = new HashMap<>();
        for (List<String> list : relation) {
            String from = list.get(0), to = list.get(2), rel = list.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new HashMap<>());
            }
            if (map.get(from).get(to) == null) map.get(from).put(to, new ArrayList<>());
            map.get(from).get(to).add(rel);
        }
        searchSequence(p1, p2, map, p1, res);
        return res;
    }

    private static void searchSequence(String start, String end, Map<String, Map<String, List<String>>> map, String path, List<String> res) {
        if (start.equals(end)) {
            res.add(path);
            return;
        }
        if (!map.containsKey(start)) {
            return;
        }
        for (String next : map.get(start).keySet()) {
            if (!path.contains(next)) {
                for (String relation : map.get(start).get(next)) {
                    searchSequence(next, end, map, path + " " + relation + " " + next, res);
                }
            }
        }
    }
}







