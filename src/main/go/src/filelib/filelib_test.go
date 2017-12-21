package filelib

import (
	"testing"
)

func TestSimpleFile(t *testing.T) {
	simpleFile := "test.txt"

	result, err := ReadLines(simpleFile)

	if err != nil {
		t.Errorf("Readlines returned error")
	}

	if (len(result) < 5) {
		t.Errorf("Readlines did not read from file %s", simpleFile)
	}
}



