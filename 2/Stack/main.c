#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct Node 
{ 
    int data; 
    struct Node* next; 
    struct Node* prev;
} typedef node;

node *head = NULL;
node *mid  = NULL;
int size;

void push(int k)
{
    size++;

    node* newNode = malloc(sizeof(node)); 
    newNode->data  = k; 
  
    newNode->prev = NULL; 
    newNode->next = head; 
  
    if (size == 1) 
    { 
        mid = newNode; 
    } 
    else
    { 
        head->prev = newNode; 
  
        if (size%2 == 1)
        {
           mid = mid->prev; 
        }
    } 
  
    head  = newNode; 
}

void pop()
{
    if (size  ==  0) 
    { 
        return; 
    } 
  
    node* remove = head; 
    head = head->next; 
  
    if (head != NULL) 
        head->prev = NULL; 
  
    size--; 
  
    if (size%2 == 0) 
        mid = mid->next; 
  
    free(remove); 
}

void findMiddle()
{
    if (size == 0)
    {
        printf("-1\n");
    }
    else
    {
        printf("%d\n", mid->data);
    }
}

void removeMiddle()
{
    if (size == 0)
    {
        return;
    }
    else if (size == 1)
    {
        head = NULL;
        mid = NULL;
        size--;
    }
    else if (size == 2)
    {
        node* remove = mid;
        head->next = NULL;
        mid = head;
        size--;
        free(remove);
    }
    else
    {
        node* remove = mid;
        if (size%2 == 0)
        {
            mid = mid->prev;
        }
        else
        {
            mid = mid->next;
        }
        
        remove->next->prev = remove->prev;
        remove->prev->next = remove->next;
        size--;
        free(remove);
    }
}

void print()
{
    node *curr = head;
    for (int i = 0; i < size; i++)
    {
        printf("%d ", curr->data);
        curr = curr->next;
    }
    printf("\n");
}

int main() 
{
    while (1)
    {
        char command[256];
        gets(command);
        
        if (strstr(command, "push") != NULL)
        {
            //split string to two strings.
            char * token = strtok(command, " ");
            token = strtok(NULL, " ");
            
            int k = atoi(token);
            push(k);
        }
        else if (strstr(command, "pop") != NULL)
        {
            pop();
        }
        else if (strstr(command, "print") != NULL)
        {
            print();
        }
        else if (strstr(command, "findMiddle") != NULL)
        {
            findMiddle();
        }
        else if (strstr(command, "removeMiddle") != NULL)
        {
            removeMiddle();
        }
        else if (strstr(command, "finish") != NULL)
        {
            return 0;
        }
    }

    return 0; 
} 