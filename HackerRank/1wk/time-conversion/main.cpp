#include <bits/stdc++.h>

using namespace std;

/*
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

string timeConversion(string s) {
    bool pm = s.substr(s.length()-2).compare("PM") == 0;
    int hour = stoi(s.substr(0, 2));

    if (pm && hour != 12)
        hour += 12;
    if (!pm && hour == 12)
        hour -= 12;

    return (hour < 10 ? "0" : "") + to_string(hour) + s.substr(2, s.length()-4);
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = timeConversion(s);

    fout << result << "\n";

    fout.close();

    return 0;
}

