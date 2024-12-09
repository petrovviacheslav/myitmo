import subprocess
import os

tests = ["first_word", "second_word", "q"*256, "yooo u", "third_word", "hard", "q"*255]
outputs = ["first_word explanation", "second_word explanation", "", "ketsvill explanation", "third_word explanation", "", "max explanation"]
errors = ["", "", "Err: string is too long!", "", "", "Err: string is not found!", ""]
codes = [0, 0, 7, 0, 0, 2, 0]

path = "./main"

def add_new_test():
    print("Enter the test, possible output, and possible error separated by a space")
    whole_test = input()
    try:
        str_test, output, error, code = whole_test.split()
        tests.add(str_test)
        outputs.add(output)
        errors.add(error)
        codes.add(code)
    except:
        print("Error! Try again")
        add_new_test()

    ask_new_test()

def ask_new_test():
    print("Do you want to add a new test? y/n")
    ans = input()
    if (ans == "n" or ans == "no"):
        test()
    elif (ans == "yes" or ans == "y"):
        add_new_test()
    else:
        print("You need to enter y/n! Try again")
        ask_new_test()
        
        

def test():
    print("====================================")
    counter_success = 0
    for i, test in enumerate(tests):
        process = subprocess.Popen(
            [path],
            stdin=subprocess.PIPE,
            stdout=subprocess.PIPE,
            stderr=subprocess.PIPE,
            text=True
        )
        out, err = process.communicate(input=test)

        if (out != outputs[i] or err != errors[i] or process.returncode != codes[i]):
            if out != outputs[i]:
                print(f"OUT: Test #{i+1} failed: \n\treceived {out}, expected {outputs[i]}")
            if err != errors[i]:
                print(f"ERROR: Test #{i+1} failed: \n\treceived {err}, expected {errors[i]}")
        else:
            print(f"Test #{i+1} passed!")
            counter_success+=1
        print("")

    print(f"\n{counter_success}/{len(tests)} tests have been successfully completed!")
    print("====================================")

if __name__ == "__main__":
    #ask_new_test()
    test()
