# Names: Alexa Selby, Alina Burlacu

# Experimental Results

## Gather Data
* After running each version of the program, namely _Sequential_, _Threaded_ and _Process_, we collect runtimes and
store those in the following table, for posterior discussion. 

| Program Type | Many Small Files | Few Large Files |
|---           |-----------------:|----------------:|
|Sequential    |        0.400 sec |      47.414 sec |
|Thread-based  |        0.377 sec |      45.411 sec |
|Process-based |        9.690 sec |      17.046 sec |
 
## Discussion
* Discuss with your team these questions:

**A) Did the Multi-threaded program (thread-based) improve the performance of the processing?** 

*If yes, explain why? If no, explain what do you think is the cause of that behavior*

The Multi-threaded program showed a slight improvement over the sequential program because it can run 
concurrent instances of the WordCount class.


**B) Did the Multi-Processing program (process-based) improve the performance of the processing?** 

*If yes, explain why? If no, explain what do you think is the cause of that behavior*

Based on the sizes of the files in both the "many small files" directory and the "few large files" directory,
the Multi-Processing program did improve the performance of the processing. The difference in processing time 
is substantially smaller compared to the sequential and multi-threading programs.

Overall the runtimes for the smaller files in the sequential and multi-threading programs were 
significantly quicker than in the multi-processing program. However, the runtime for the larger files
in the sequential and multi-threading programs were significantly slower than the multi-processing program.
Therefore, the performance of multi-processing depends on the data.


**C) Which are the tradeoffs of achieving better performance?**

The most significant tradeoff of achieving better performance is the memory usage. Additionally, spawning
processes takes longer than spawning threads, and communication between processes can be quite costly. Plus,
sharing data across processes requires maintaining locks and synchronization to create process safe programs.
