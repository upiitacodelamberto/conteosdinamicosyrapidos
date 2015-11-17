INCLUDE_DIRS:= include/
SOURCE_DIRS:=  src/

CFILES:= main.cpp modelo.cpp String_Tokenizer.cpp
TARGET = conteosdinamicos
INCLUDE_FLAGS:=$(patsubst %,-I%,$(INCLUDE_DIRS))

CC=g++

CFLAGS=-g -Wall 
CPPFLAGS= $(INCLUDE_FLAGS)
vpath %.h $(INCLUDE_DIRS)
vpath %.cpp $(SOURCE_DIRS)

vpath %.o objects

COBJECTS:= $(patsubst %.cpp,%.o,$(CFILES)) 
ASMOBJECTS:= $(patsubst %.S,%.o,$(ASM_FILES))

all: $(TARGET).out
objects:
	mkdir objects

$(TARGET).out: objects $(COBJECTS) 
	$(CC) $(CFLAGS) objects/*.o  -o $@

$(COBJECTS): %.o: %.cpp
	$(CC) $(CFLAGS) $(CPPFLAGS) -c $< -o objects/$@
$(ASMOBJECTS): %.o: %.S
	$(CC) $(CFLAGS) $(CPPFLAGS) -c $< -o objects/$@


.PHONY: clean 
clean:
	rm -frv objects
	rm $(TARGET).out
	
