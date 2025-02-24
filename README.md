# Getting Started

### Requirements
* Set JAVA_HOME in system vars (jdk folder)
* Add jdk\bin folder to PATH user variable
* [Download apache kafka](https://www.apache.org/dyn/closer.cgi?path=/kafka/2.6.0/kafka_2.12-2.6.0.tgz)
* Unzip kafka folder, rename and move to a drive root: E:,C:

### Prep
* Move to kafka folder `cd :E\kafkafolder`
* in case of getting an error for the next commands, most probably the java env variable has some issue
* start zookeeper in cmd `.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties`
* start kafka in cmd `.\bin\windows\kafka-server-start.bat .\config\server.properties`
* create a kafka topic `.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic myKafkaTopic`
* lists topics `.\bin\windows\kafka-topics.bat --bootstrap-server=localhost:9092 --list`

### How to test
* Run app
#### For topic1, consumerId 1
* Send any message by using webbrowser like this:
- `http://localhost:9090/send?msg=1243423`
- `http://localhost:9090/send?msg=just a new message`
* Should see messages being sent by producer and received by consumer in logs
* Use `http://localhost:9090/getAll` to get a list of sent messages
#### For topic2, consumerId 2
- Same as above, just change url path `http://localhost:9090/sendByOther?msg=item5`

## Extra info
- `https://javatechonline.com/how-to-work-with-apache-kafka-in-spring-boot/`
- `https://medium.com/@abhishekranjandev/a-comprehensive-guide-to-integrating-kafka-in-a-spring-boot-application-a4b912aee62e`
