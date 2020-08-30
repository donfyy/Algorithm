class _557_1(object):
    def reverseWords(self, s):
        return ' '.join(s.split()[::-1])[::-1]

class _557_2(object):
    def reverseWords(self, s):
        return ' '.join(x[::-1] for x in s.split()