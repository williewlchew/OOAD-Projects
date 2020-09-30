# Zoo Simulator pt. 2
### **By Willie Chew and Sricharan Reddy Varra**

# Goal of program/Comments and Assumptions
Zoo Simulator is supposed to simulate the happening of a zoo. The zoo is home to a animals that range from 10 different species and belong to 4 different families (Pachyderm, Feline, Canine, Ursidae). Each species' count in the zoo ranges from 2 to 5 animals. A data set of baby names is used to find an appropriate name for each animal that corresponds with their species <sup>[1]</sup>. A zoo keeper arrives at the zoo everyday and does zoo keeping tasks. All actions of the zoo keeper and reactions from the animals were recorded via text and outputted to the *dayatthezoo.out* file. 

We added the Zoo Food Server who cleans, cooks, and serves food twice a day. In addition to this we added a clock, where within each unit of time, the Zookeeper and the Zoo Food Server perform certain actions. For example, at 12:00 PM and 5:00 PM food is served. The zoo opens at 8:00 AM and closes at 8:00 PM.

# Issues Encountered
The largest issue we had was that in our **Zoo** class, which is dedicated to simulating the Zoo itself, there were issues when it came to outputting the text into the output file. Essentially what would happen is that for each day:

* Start of day
* Zookeeper output
* Zookeeper output
* ...
* Zookeeper output
* Zoo Food Server output
* Zoo Food Server output
* ...
* Zoo Food Server output
* End of day

The events are not in chronological order with respect to the clock, instead they are chronological with respect to the Zookeeper and the zoo food sever. In addition to this the output for the Zoo Food Server had significantly more outputs than expected (about 20-30 *"Zoo Food Server Z-man has arrived"*). We believe the issue was with how we were accumulating the output of each Zoo employee and the animals into a String Builder buffer. We had to slightly restructure how we implemented the buffer. We ended up using Message Beans to set messages that bet returned to the ZooAnnouncer, who in the end constructs
The overall buffer.

# Running the program
Using a code runner, we recommend IntelleJ, navigate to the *Project 2/* directory and build the project. Once built, run the *main.java*. If using IntelleJ, this can be accomplished by finding it in the file explorer in IntelleJ and right clicking it. A run option should then be offered.

# UML


* [UML Class Diagram](./UML%20Diagrams/OOAD%20Proj%202%20-%20UML%20Class%20Diagram.pdf)
* [UML Sequence Diagram](./UML%20Diagrams/OOAD%20Proj%202%20-%20UML%20Sequence%20Diagram.pdf)
* [UML Activity Diagram](./UML%20Diagrams/OOAD%20Proj%202%20-%20UML%20Activity%20Diagram.pdf)
* [UML ZooKeeper Use Case](./UML%20Diagrams/OOAD%20Proj%202%20-%20ZooKeeper%20Use%20Case.pdf)

# References
<sup>[1]</sup>[Baby names from Social Security Card Applications National Data](https://catalog.data.gov/dataset/baby-names-from-social-security-card-applications-national-level-data)
