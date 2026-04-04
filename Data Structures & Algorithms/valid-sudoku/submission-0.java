class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> counted = new HashSet<>();
        // check rows
        for(int i = 0 ; i < 9; i++){
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                else if(counted.contains(board[i][j])){
                    return false;
                }else{
                    counted.add(board[i][j]);
                }
            }
            counted.clear();
        }
        counted.clear();
        // check columns
        for(int i = 0 ; i < 9; i++){
            for(int j = 0 ; j < 9 ; j++){
                if(board[j][i]=='.'){
                    continue;
                }
                else if(counted.contains(board[j][i])){
                    return false;
                }else{
                    counted.add(board[j][i]);
                }
            }
            counted.clear();
        }
        
        // check 3*3 box
        for(int k = 0 ; k < 9 ; k+=3){
            counted.clear();
            for(int i = 0; i <3;i++){
                for(int j = 0 ; j < 3 ; j++){
                    if(board[k+i][j]=='.'){
                        continue;
                    }
                    else if(counted.contains(board[k+i][j])){
                        return false;
                    }else{
                        counted.add(board[k+i][j]);
                    }
                }
            }
        }

        for(int k = 0 ; k < 9 ; k+=3){
            counted.clear();
            for(int i = 0; i <3;i++){
                for(int j = 0 ; j < 3 ; j++){
                    if(board[k+i][3+j]=='.'){
                        continue;
                    }
                    else if(counted.contains(board[k+i][3+j])){
                        return false;
                    }else{
                        counted.add(board[k+i][3+j]);
                    }
                }
            }
        }
        
        for(int k = 0 ; k < 9 ; k+=3){
            counted.clear();
            for(int i = 0; i <3;i++){
                for(int j = 0 ; j < 3 ; j++){
                    if(board[k+i][6+j]=='.'){
                        continue;
                    }
                    else if(counted.contains(board[k+i][6+j])){
                        return false;
                    }else{
                        counted.add(board[k+i][6+j]);
                    }
                }
            }
        }
        return true;
    }
}
