#include<stdio.h>
#include<conio.h>
#include<string.h>
int main()
{
    char str[100];
    int num,flag,count=0;
    int length;
    flag=0;
    printf("Enter the number of strings : ");
    scanf("%d",&num);
    for(int i=0;i<num;i++)
    {
        printf("Enter a string: ");
        scanf("%s", str);


    length = strlen(str);
    if(length<2)
    {
        printf("Invalid string.");
    }
    else if(length==2)
    {
        for(int j=0;j<2;j++)
        {
            if(str[j]=='b')
            {
                flag++;
            }
        }
        if(flag==2)
        {
            printf("Valid string.");
        }
        else{
            printf("Invalid string.");
        }
    }
    else{
        if(str[0]=='a' && str[length-1]=='b' && str[length-2]=='b')
        {
            for(int a=0;a<length-2;a++)
            {
                if(str[a]=='b')
                {
                    count++;
                }
            }
            if(count!=0)
            {
                printf("Invalid string.");
            }
            else
            {
                printf("Valid string.");
            }
        }
        else{
            printf("Invalid string.");
        }
    }
    printf("\n");
    }

    return 0;
}

//for regular expression (a^+bb)
/*int main()
{
    char str[100];
    int num,flag,count=0;
    int length;
    flag=0;
    printf("Enter the number of strings : ");
    scanf("%d",&num);
    for(int i=0;i<num;i++)
    {
        printf("Enter a string: ");
        scanf("%s", str);


    length = strlen(str);
    if(length<3)
    {
        printf("Invalid string.");
    }
    else if(length==3)
    {
        if(str[0]=='a')
        {
            for(int j=1;j<3;j++)
        {
            if(str[j]=='b')
            {
                flag++;
            }
        }
        if(flag==2)
        {
            printf("Valid string.");
        }
        else{
            printf("Invalid string.");
        }
        }
    }
    else{
        if(str[0]=='a' && str[length-2]=='a' && str[length-1]=='b' && str[length-2]=='b')
        {
            for(int a=0;a<length-3;a++)
            {
                if(str[a]=='b')
                {
                    count++;
                }
            }
            if(count!=0)
            {
                printf("Invalid string.");
            }
            else
            {
                printf("Valid string.");
            }
        }
        else{
            printf("Invalid string.");
        }
    }
    printf("\n");
    }

    return 0;
}*/





