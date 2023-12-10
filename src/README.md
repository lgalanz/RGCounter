# RGCounter

RGCounter is the Java program to count the red-laser signals and green-laser signals in the course of sequencing a collection of DNA strings.

## Java requirements

The program is implemented with **Java 17**.

## IDE

The program is implemented using IntelliJ IDEA 2021.2.2 (Community Edition).

## Installation

Compiled files are located in the directory .\DKFZAssessment\out\production\DKFZAssessment.
The program requires one parameter: absolute paths to the input files.

**The input file** must be located in the input folder of the root directory (.\DKFZAssessment\input) and should contain a list of sequences (see example below).

**The output folder** must exist and be located in the root directory (.\DKFZAssessment\output).

The program can be run from *.\DKFZAssessment\out\production\DKFZAssessment* using the following command:
```bash
.\DKFZAssessment\out\production\DKFZAssessment> java com.lgalanzovskaia.dkfz.RGCounter input.txt
```

#### Example:

```bash
F:\DKFZAssessment\out\production\DKFZAssessment> java com.lgalanzovskaia.dkfz.RGCounter input.txt
```

## Example of the input file format
```
GTCAGTCA
AGTAGTAC
CTCTGACA
ACCGGTCGACTGCGCGGAAGCCGGCCGAA
GTCGTTCGGAATGCCGTTGCTCTGTAAA
ATTGCATTGCATGGGCGCGATGCATTTGGTTAATTCCTCG
CTTGCTTAAATGTGCA
...
```
