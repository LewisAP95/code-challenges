import time
# Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.

def __main__():
    # Setting up a scheduler for testing, and let it run for 1 minute
    start = time.time()
    job_scheduler = scheduler()
    job_scheduler.add_func(test, 10000)
    job_scheduler.add_func(test_2, 30000)
    # In a real use case the scheduler would either check itself at set times or be controlled by another service
    while(time.time() - start < 60):
        job_scheduler.check()

# Test jobs
def test():
    print("Test 1 called.")

def test_2():
    print("Test 2 called.")

class scheduler:

    # Scheduler stores a queue of functions, allowing new ones and the desired calling time to be added
    def __init__(self):
        self.queue = []
    
    # Newly added functions are stored in an array alongside their given calling time
    def add_func(self, func, time_until):
        print(f"Function being added: {func}")
        self.queue.append([func, time.time()*1000 + time_until])

    # When told to check its queue, accesses the time_until portion of the stored functions array-
    # -if the time has been met/passed, calls the function and takes it out of the queue
    def check(self):
        for f in self.queue:
            if f[1] < time.time()*1000:
                f[0]()
                self.queue.remove(f)

if __name__ == "__main__":
    __main__()