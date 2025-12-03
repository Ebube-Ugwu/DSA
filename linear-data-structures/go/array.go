package main

import (
	"slices"
	"fmt"
)

type Array struct {
	count int
	items []int
}

func (a *Array) insert(item int) {
	a.items[a.count] = item
	a.count++
}

func (a *Array) contains(item int) bool {
	return slices.Contains(a.items, item)	
}

func (a *Array) ItemAt(index int) (int, error) {
	if index >= a.count || index < 0 {
		return index, fmt.Errorf("invalid argument")
	}
	return a.items[index], nil
}