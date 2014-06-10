package taylor.math;

public enum Function {
    
    CONSTANT {
        @Override
        public Term getDerivative(Term t) {
            return null;
        }
    },
    POLYNOMIAL {
        @Override
        public Term getDerivative(Term t) {
            return null;
        }
    },
    LOG {
        @Override
        public Term getDerivative(Term t) {
            return null;
        }
    },
    SIN {
        @Override
        public Term getDerivative(Term t) {
            return null;
        }
    },
    COS {
        @Override
        public Term getDerivative(Term t) {
            return null;
        }
    };
    
    public abstract Term getDerivative(Term t);
    
    Function() {
        
    }
}
