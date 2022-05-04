#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <stack>
using namespace std;

class Queue {
public:
    void enqueue(int val)
    {
        in_stack.push(val);
    }

    void dequeue()
    {
        front();
        out_stack.pop();
    }

    int front()
    {
        if (out_stack.empty()) {
            while (!in_stack.empty()) {
                out_stack.push(in_stack.top());
                in_stack.pop();
            }
        }
        return out_stack.top();
    }
private:
    stack<int> in_stack;
    stack<int> out_stack;
};

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */

    int queries;
    cin >> queries;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    Queue q = Queue();

    for (int queries_iter = 0; queries_iter < queries; queries_iter++) {
        int type, val;
        cin >> type;

        if (type == 1) {
            cin >> val;
            q.enqueue(val);
        } else if (type == 2) {
            q.dequeue();
        } else {
            cout << q.front() << endl;
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

    return 0;
}

