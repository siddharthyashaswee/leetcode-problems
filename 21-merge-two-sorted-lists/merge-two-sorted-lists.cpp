/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {} //constructor that takes two parameters: an integer x and a pointer to another ListNode.
        //initializer list; it directly initializes the struct’s data members val and next with those parameter values before the constructor body runs.
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {

        ListNode* list1_ptr = list1;
        ListNode* list1_prev_ptr = nullptr;
        ListNode* list2_ptr = list2;
        ListNode* list2_next_ptr = nullptr;
        ListNode* start_ptr = nullptr;

        //we will put in list2 into list 1 and maintain pos using list1_ptr and list2_ptr

        if(list1 == nullptr) return list2; //edge cases
        else if(list2 == nullptr) return list1;

        if(list2->val <= list1->val) start_ptr = list2;
        else start_ptr = list1;


        while(list2_ptr != nullptr){
            if(list1_ptr!=nullptr){
                if(list2_ptr->val <= list1_ptr->val){ // insert because list2 value is smaller/equal
                    list2_next_ptr = list2_ptr->next; //save next pointer
                    if(list1_prev_ptr != nullptr){
                        list1_prev_ptr->next = list2_ptr; //attach tail and move the prev reference
                    }
                    list1_prev_ptr = list2_ptr;
                    list2_ptr->next = list1_ptr; //dereference
                    list2_ptr = list2_next_ptr; //move to next entry in list2
                    
                }else{
                    list1_prev_ptr = list1_ptr;
                    list1_ptr = list1_ptr->next;
                }
            }else{ //list 1 is empty, append remaining list 2
                list1_prev_ptr->next = list2_ptr;
                break;
            }
        }
        return start_ptr;
    }
};