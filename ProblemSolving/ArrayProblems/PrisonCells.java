/*
There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)



Example 1:

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation:
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Example 2:

Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]
 */

class PrisonCells {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int size = cells.length;
        N=((N-1)%14)+1;
        for(int i =0; i<N; i++){
            //printArray(cells, size, i);
            cells = getRearrangedRoe(cells, size);
        }
        return cells;
    }

    private int[] getRearrangedRoe(int[] cells, int size){

        int prev = cells[0];
        int next = cells[2];
        for(int i=1; i<size-1; i++){
            if(prev == next){
                prev = cells[i];
                if(i+2<size){
                    next = cells[i+2];
                }
                cells[i] =1;
            }else{
                prev = cells[i];
                if(i+2<size){
                    next = cells[i+2];
                }
                cells[i] =0;
            }
        }
        cells[0]=0;
        cells[size-1]=0;
        return cells;
    }

    //debug
    private void printArray(int[] cells, int size, int nDay){
        System.out.print("Day "+nDay+":- ");
        for(int i=0; i<size; i++){
            System.out.print(cells[i]+ " ");
        }
        System.out.print("\n");
    }
}