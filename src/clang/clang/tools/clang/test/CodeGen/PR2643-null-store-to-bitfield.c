// RUN: clang-cc -emit-llvm -o - %s
// PR2643

void foo() {
  struct {
    int a : 1;
    int b : 1;
  } entry = {0};
}

