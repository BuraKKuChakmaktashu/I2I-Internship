package main

import (
	"bufio"
	"fmt"
	"log"
	"math"
	"os"
	"strconv"
)

func checkPrimeNumber(num int) {
	if num < 2 {
		fmt.Printf("%v must be greater than 2. \n", num)
		return
	}
	sq_root := int(math.Sqrt(float64(num)))
	for i := 2; i <= sq_root; i++ {
		if num%i == 0 {
			fmt.Printf("%v is not a Prime Number \n", num)
			return
		}
	}
	fmt.Printf("%v is a Prime Number \n", num)
	return
}

func main() {
	file, err := os.Open("myFile.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	scanner.Split(bufio.ScanWords)
	var numbers []int

	for scanner.Scan() {
		x, err := strconv.Atoi(scanner.Text())
		if err != nil {
			fmt.Print(err)
		}
		numbers = append(numbers, x)
	}

	for i := 0; i < len(numbers); i++ {
		checkPrimeNumber(numbers[i])
	}

	if err := scanner.Err(); err != nil {
		log.Fatal(err)
	}

}
