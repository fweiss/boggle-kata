CRC

Board
- has width and height
- has cells
- uses Alphabet to validate cells

WordGenerator
- can generate list of words
- uses Board to get cells
- uses Path to generate words

Path
- has nodes
- can create list of next paths

PathOffsets
- can list legal offsets for a given cell

Dictionary
- has words
- can check word
- uses Alphabet to validate words

Alphabet
- can check letter
- can create random letter

Game
- can setup up Board
- uses Board to hold letters
- uses Alphabet to generate random letters
- uses WordGenerator to list words
- uses Dictionary to check words

Complexity
According to a preliminary 4x4 implementation, there are 12,029,641 distinct paths of length 0-16.

A simplification may be to base the search on the dictionary. For example, suppose a path starts at a cell
containing the latter "Q", but the dictionary has no word beginning with "Q". Then that path, and all its
extensions would be fruitless. and would not have to be searched, or even generated.
