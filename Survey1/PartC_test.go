package main

//Carter Copen
//This follows academic integrity policy
import (
	"fmt"
	"testing"
)

func Factorial(n int) int {
	if n <= 1 {
		return 1
	}

	return n * Factorial(n-1)
}

func Combinations(n int, r int) int {
	if 0 <= r && r <= n {
		return Factorial(n) / (Factorial(r) * Factorial(n-r))
	} else {
		return 0
	}
}

func Hypercake(n int, k int) int {
	result := 0
	for i := 0; i <= k; i++ {
		result += Combinations(n, i)
	}
	return result
}

func TestHypercake(t *testing.T) {
	test1 := Hypercake(0, 2)
	test2 := Hypercake(0, 3)
	test3 := Hypercake(0, 4)
	test4 := Hypercake(0, 5)

	test5 := Hypercake(10, 2)
	test6 := Hypercake(10, 3)
	test7 := Hypercake(10, 4)
	test8 := Hypercake(10, 5)

	test9 := Hypercake(1, 2)
	test10 := Hypercake(1, 3)
	test11 := Hypercake(1, 4)
	test12 := Hypercake(1, 5)

	test13 := Hypercake(2, 2)
	test14 := Hypercake(2, 3)
	test15 := Hypercake(2, 4)
	test16 := Hypercake(2, 5)

	test17 := Hypercake(3, 2)
	test18 := Hypercake(3, 3)
	test19 := Hypercake(3, 4)
	test20 := Hypercake(3, 5)

	test21 := Hypercake(4, 2)
	test22 := Hypercake(4, 3)
	test23 := Hypercake(4, 4)
	test24 := Hypercake(4, 5)

	test25 := Hypercake(5, 2)
	test26 := Hypercake(5, 3)
	test27 := Hypercake(5, 4)
	test28 := Hypercake(5, 5)

	test29 := Hypercake(6, 2)
	test30 := Hypercake(6, 3)
	test31 := Hypercake(6, 4)
	test32 := Hypercake(6, 5)

	test33 := Hypercake(7, 2)
	test34 := Hypercake(7, 3)
	test35 := Hypercake(7, 4)
	test36 := Hypercake(7, 5)

	test37 := Hypercake(8, 2)
	test38 := Hypercake(8, 3)
	test39 := Hypercake(8, 4)
	test40 := Hypercake(8, 5)

	test41 := Hypercake(9, 2)
	test42 := Hypercake(9, 3)
	test43 := Hypercake(9, 4)
	test44 := Hypercake(9, 5)

	if test1 != 1 {
		t.Errorf("Hypercake(0, 2) = %d; want 1", test1)
	}
	if test2 != 1 {
		t.Errorf("Hypercake(0, 3) = %d; want 1", test2)
	}
	if test3 != 1 {
		t.Errorf("Hypercake(0, 4) = %d; want 1", test3)
	}
	if test4 != 1 {
		t.Errorf("Hypercake(0, 5) = %d; want 1", test4)
	}

	if test5 != 56 {
		t.Errorf("Hypercake(10, 2) = %d; want 56", test5)
	}
	if test6 != 176 {
		t.Errorf("Hypercake(10, 3) = %d; want 176", test6)
	}
	if test7 != 386 {
		t.Errorf("Hypercake(10, 4) = %d; want 386", test7)
	}
	if test8 != 638 {
		t.Errorf("Hypercake(10, 5) = %d; want 638", test8)
	}

	if test9 != 2 {
		t.Errorf("Hypercake(1, 2) = %d; want 2", test9)
	}
	if test10 != 2 {
		t.Errorf("Hypercake(1, 3) = %d; want 2", test10)
	}
	if test11 != 2 {
		t.Errorf("Hypercake(1, 4) = %d; want 2", test11)
	}
	if test12 != 2 {
		t.Errorf("Hypercake(1, 5) = %d; want 2", test12)
	}

	if test13 != 4 {
		t.Errorf("Hypercake(2, 2) = %d; want 4", test13)
	}
	if test14 != 4 {
		t.Errorf("Hypercake(2, 3) = %d; want 4", test14)
	}
	if test15 != 4 {
		t.Errorf("Hypercake(2, 4) = %d; want 4", test15)
	}
	if test16 != 4 {
		t.Errorf("Hypercake(2, 5) = %d; want 4", test16)
	}

	if test17 != 7 {
		t.Errorf("Hypercake(3, 2) = %d; want 7", test17)
	}
	if test18 != 8 {
		t.Errorf("Hypercake(3, 3) = %d; want 8", test18)
	}
	if test19 != 8 {
		t.Errorf("Hypercake(3, 4) = %d; want 8", test19)
	}
	if test20 != 8 {
		t.Errorf("Hypercake(3, 5) = %d; want 8", test20)
	}

	if test21 != 11 {
		t.Errorf("Hypercake(4, 2) = %d; want 11", test17)
	}
	if test22 != 15 {
		t.Errorf("Hypercake(4, 3) = %d; want 15", test18)
	}
	if test23 != 16 {
		t.Errorf("Hypercake(4, 4) = %d; want 16", test19)
	}
	if test24 != 16 {
		t.Errorf("Hypercake(4, 5) = %d; want 16", test20)
	}

	if test25 != 16 {
		t.Errorf("Hypercake(5, 2) = %d; want 16", test25)
	}
	if test26 != 26 {
		t.Errorf("Hypercake(5, 3) = %d; want 26", test26)
	}
	if test27 != 31 {
		t.Errorf("Hypercake(5, 4) = %d; want 31", test27)
	}
	if test28 != 32 {
		t.Errorf("Hypercake(5, 5) = %d; want 32", test28)
	}

	if test29 != 22 {
		t.Errorf("Hypercake(6, 2) = %d; want 22", test29)
	}
	if test30 != 42 {
		t.Errorf("Hypercake(6, 3) = %d; want 42", test30)
	}
	if test31 != 57 {
		t.Errorf("Hypercake(6, 4) = %d; want 57", test31)
	}
	if test32 != 63 {
		t.Errorf("Hypercake(6, 5) = %d; want 63", test32)
	}

	if test33 != 29 {
		t.Errorf("Hypercake(7, 2) = %d; want 29", test33)
	}
	if test34 != 64 {
		t.Errorf("Hypercake(7, 3) = %d; want 64", test34)
	}
	if test35 != 99 {
		t.Errorf("Hypercake(7, 4) = %d; want 99", test35)
	}
	if test36 != 120 {
		t.Errorf("Hypercake(7, 5) = %d; want 120", test37)
	}

	if test37 != 37 {
		t.Errorf("Hypercake(8, 2) = %d; want 37", test37)
	}
	if test38 != 93 {
		t.Errorf("Hypercake(8, 3) = %d; want 93", test38)
	}
	if test39 != 163 {
		t.Errorf("Hypercake(8, 4) = %d; want 163", test39)
	}
	if test40 != 219 {
		t.Errorf("Hypercake(8, 5) = %d; want 219", test40)
	}

	if test41 != 46 {
		t.Errorf("Hypercake(9, 2) = %d; want 46", test41)
	}
	if test42 != 130 {
		t.Errorf("Hypercake(9, 3) = %d; want 130", test42)
	}
	if test43 != 256 {
		t.Errorf("Hypercake(9, 4) = %d; want 256", test43)
	}
	if test44 != 382 {
		t.Errorf("Hypercake(9, 5) = %d; want 382", test44)
	}

}

func main() {
	fmt.Println("Enter Cuts: ")
	var n int
	fmt.Scanln(&n)

	fmt.Println("Enter Dimensions: ")
	var k int
	fmt.Scanln(&k)

	fmt.Println(Hypercake(n, k))
}
