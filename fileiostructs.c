#include <stdio.h>

FILE *outputFile;

typedef struct{

	int id;
	char name[256];
	char house[256];
}
student;

int main(void){

	 int number_of_users;
	 printf("enter the number of students\n");
	 scanf("%d",&number_of_users);

	 student students[number_of_users];

	 for(int i=0;i<number_of_users;i++){
	 	 
	 	 printf("enter student id\n");
	 	 scanf("%d",&students[i].id);

	 	 printf("enter student name\n");
	 	 scanf("%s",students[i].name);
	 	 

	 	 printf("enter student house\n");
	 	 scanf("%s",students[i].house);
	 }

	 outputFile = fopen ("data", "w");

	 if ( outputFile == NULL )
			printf ("*** data could not be opened.\n");
	else{

			for(int i=0;i<number_of_users;i++){
				 fprintf( outputFile,	"%d,",  students[i].id);
				 fprintf( outputFile,	"%s,",	students[i].name);
				 fprintf( outputFile,	"%s\n",	students[i].house);
			}

		}


}