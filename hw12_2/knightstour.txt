Alexia Leong
APCS2 pd1
HW12 -  +3R|\/|1|\|4|_  1|_|_|\|3$$
2018-03-02   

Questions:
Q0. From Demo.java, we can see that it is possible to have multiple class definitions in one .java file but only one (Demo) is declared public. If you rename the file to Boardasaurus.java it doesn't run. Also, even though there are two different classes in one file, it still acts as if the two files are separated into two files.

Q1. The command line arguments are processed in class Demo, the board size and the delay time are inputted after $ java Demo. The board size is args[0] because it's the first argument after $ java Demo and args[1] is the delay time. If the arguments aren't possible, an exception is thrown. 

Q2. If there are no command line arguments given then the default (a board size of 8 and the delay time of 500 ms) is used.

Q3. Purpose of the recursion if to keep putting the moves in a random spot until the moves reach the max. I don't think it's necessary because the places are randomly chosen so it doesn't matter where a piece can go because it can repeat. 

Q4. A board that has two row/columns of -1 and the other positions are filled with 0. Then starting from the board size, the 0s turn into the number of moves but the 0s are chosen randomly. A new board is printed under the old one after a move has been placed. This happens until the number of moves reaches n*n.

Q5. Run until the number of moves reaches n*n.

Q6. ANSI stands for the American National Standards Institute that creates standards for the computer industry like standard ANSI codes that are helpful for clearing the terminal and making the terminal appear the way you want. 

Q7. This matched my expectations in the way it looked like and how the numbers changed (the way moves were changing numbers) but I didn't expect the whole board to update itself without printing a new one, it just refreshed itself. Also it went up to n*n+1 moves and not n*n. 

Q8. I think that the random places for the next move have to be changed to pick a valid spot a knight can move. Also, there can't be any repeats of where the knight goes. 


Latest Step by Step Algorithm for Knight's tour
1.	If there are no squares left (the tour is over), you have the solution and stop
2.	Start by placing knight at top left corner
3.	For the knight on the board,
	a.	If possible, move knight to the space two down and one to the right (like addQueen)
		i.	Then recursively move the knight to any of the possible positions
	b.	If that move wasn't possible choose remove that one (like removeQueen) and choose another one of the open spots a knight can move and go there (possibilities are the ones that go two down/up and over, the ones that go two across then up, and then the ones that go one down/up and over two, check the possibilities in this order and then go to the first one avaliable if there is one)
		i.	Then recursively move the knight to any more avaliable spots.
	c.	If the tours for a and b don't work out, that tour doesn't work and end the tour
	d.	Otherwise, a solution is found.
