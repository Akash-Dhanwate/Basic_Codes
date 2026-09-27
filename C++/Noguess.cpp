#include <iostream>
#include <random>
using namespace::std;
int main() {

    cout << "Welcome to No Guessing Game" << endl;
    cout << "RULE : You need to Guess the Number that is selected by the Game" << endl;
    cout << "       And these loop continue until you select the correct number." << endl;
    srand(time(0));
    int random_num = (rand() % 100) + 1;
    while(true){
        int no;
        cout << "Number Between (1 - 100)" << endl;
        cout << " Enter the Number :" ;
        cin >> no;
        if(no == random_num){
            cout << "You get it" << endl;
            break;
        }
        else {
            cout << "try again..😴" << " ( Hint : ";
            if(random_num > no){
                cout << "Too Small )" << endl;
            }
            else{
                cout << "Too big )" << endl;
            }
        }
    }
    return 0;
}