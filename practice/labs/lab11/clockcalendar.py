from clock import Clock
from calendar import Calendar
from clock import Clock
from calendar import Calendar

class ClockCalendar(Clock, Calendar):
    def __init__(self, month, day, year, hour, minute, second):  
        #super(ClockCalendar, self).__init__(hour, minute, second)
        #super(ClockCalendar, self).__init__(day,month,year)
        Clock.__init__(self,hour,minute,second)
        Calendar.__init__(self,day,month,year)

    def __str__(self):
        return Calendar.__str__(self) + "," + Clock.__str__(self)

    def tick(self):
        Clock.tick(self)
        if(self.hours == 0 and self.minutes == 0 and self.seconds == 0):
            Calendar.advance(self)

x = ClockCalendar(12,31,2013,23,59,59)
print('One tick from ', x, end=' ')
x.tick()
print('to ',x)

x = ClockCalendar(2,28,1900,23,59,59)
print('One tick form ', x, end=' ')
x.tick()
print('to ',x)

x = ClockCalendar(2,28,2000, 23, 59, 59)
print('One tick from ', x, end=' ')
x.tick()
print('to ', x)

x = ClockCalendar(2,7,2013,13,55,40)
print('One tick from ', x, end=' ')
x.tick()
print('to ', x)

