%define label 0

%macro colon 2
    %ifstr %1
      %ifid %2
          %2: dq label
              db %1, 0
          %define label %2

      %else
          %error "err: invalid id in 2nd arg"
      %endif
    %else
        %error "err: invalid str in 1st arg"
    %endif
%endmacro
