%define i ""
%macro repeat_symbol 2		
        %define i ""
        %rep %1
                %strcat i i, %2
        %endrep
%endmacro
