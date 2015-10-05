all:  AppTestDdC
CPP=g++
AppTestDdC:TestDdCasilla.o DdCasilla.o DraCanseco.o
	${CPP} -o $@ TestDdCasilla.o DdCasilla.o DraCanseco.o
#AppTestDdC:TestDdCasilla.o DdCasilla.o 
#	${CPP} -o $@ TestDdCasilla.o DdCasilla.o 

clean:
	rm -v *.o AppTestDdC
