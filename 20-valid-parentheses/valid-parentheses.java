class Solution {
    public boolean isValid(String s) {

        if(s.length()%2!=0){
            return false;
        }

        Stack<Character> str_stack = new Stack<>();
        // char[] string_array = s.toCharArray(); // will use less memory, than using charAt() string function
        // int n = string_array.length;

        // for(int i=0; i<n; i++){
        for(char c: s.toCharArray()){ //enhanced for

            // if(string_array[i]=='['||string_array[i]=='{'||string_array[i]=='('){
            if(c=='['||c=='{'||c=='('){
                // str_stack.push(string_array[i]);
                str_stack.push(c);
            }else{
                if(str_stack.isEmpty()){
                        return false;
                }
                // switch(string_array[i]) {
                switch(c) {
                    case ']':
                        if(str_stack.peek()=='['){
                            str_stack.pop();
                        }else{
                            // str_stack.push(']');
                            return false;
                        } //no need to push, will not match anyway
                        break;
                    case '}':
                        if(str_stack.peek()=='{'){
                            str_stack.pop();
                        }else{
                            // str_stack.push('}');
                            return false;
                        }
                        break;
                    case ')':
                        if(str_stack.peek()=='('){
                            str_stack.pop();
                        }else{
                            // str_stack.push(')');
                            return false;
                        }
                        break;
                    default:
                        continue;
                }

            }
            
        }

        //version 2, more memory LOLOL
        // for(int i=0; i<s.length(); i++){

        //     if(s.charAt(i)=='['|| s.charAt(i)=='{'||s.charAt(i)=='('){
        //         str_stack.push(s.charAt(i));
        //     }else{
        //         if(str_stack.isEmpty()){
        //                 return false;
        //         }
        //         switch(s.charAt(i)) {
        //             case ']':
        //                 if(str_stack.peek()=='['){
        //                     str_stack.pop();
        //                 }else{
        //                     str_stack.push(']');
        //                 }
        //                 break;
        //             case '}':
        //                 if(str_stack.peek()=='{'){
        //                     str_stack.pop();
        //                 }else{
        //                     str_stack.push('}');
        //                 }
        //                 break;
        //             case ')':
        //                 if(str_stack.peek()=='('){
        //                     str_stack.pop();
        //                 }else{
        //                     str_stack.push(')');
        //                 }
        //                 break;
        //             default:
        //                 continue;
        //         }
        //     }
        // }
        // if (str_stack.isEmpty()){
        //     return true;
        // }else{
        //     return false;
        // }
        return str_stack.isEmpty();
    }
}