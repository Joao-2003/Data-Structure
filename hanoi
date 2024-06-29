#include <iostream>
#include <ctime>
#include <iomanip>

void solve_toh(int n, char source, char target, char auxiliary, long long &moves) {
    if (n == 1) {
        moves++;
        return;
    }
    solve_toh(n - 1, source, auxiliary, target, moves);
    moves++;
    solve_toh(n - 1, auxiliary, target, source, moves);
}

void format_time(double seconds) {
    int total_seconds = static_cast<int>(seconds);
    int hours = total_seconds / 3600;
    int minutes = (total_seconds % 3600) / 60;
    int remaining_seconds = total_seconds % 60;
    int milliseconds = static_cast<int>((seconds - total_seconds) * 1000);

    std::cout << std::setfill('0');
    std::cout << std::setw(2) << hours << ":";
    std::cout << std::setw(2) << minutes << ":";
    std::cout << std::setw(2) << remaining_seconds << ":";
    std::cout << std::setw(2) << milliseconds << std::endl;
}

double time_execution(int n, long long &moves) {
    clock_t start_time = clock();
    solve_toh(n, 'A', 'C', 'B', moves);
    clock_t end_time = clock();
    double execution_time = static_cast<double>(end_time - start_time) / CLOCKS_PER_SEC;
    format_time(execution_time);
    return execution_time;
}

int main() {
    int input_list[] = {1, 10, 20, 30, 40, 41};
    for (int i = 0; i < sizeof(input_list); ++i) {
        int n = input_list[i];
        long long moves = 0;
        std::cout << "Time to solve for " << n << " disks: ";
        double execution_time = time_execution(n, moves);
        std::cout << "Number of moves: " << moves << std::endl;
    }
    return 0;
}
