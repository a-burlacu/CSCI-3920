Team members: Alina Burlacu, Alexa Selby 

We could open the file using mode = "a" so that two files can edit the file without overwriting. 


    files = [] # a list of filenames 
    for filename in files:
        with open(filename, mode="a") as file:
            while line := file.readline():
                count_line_words(line, word_count)

        return word_count